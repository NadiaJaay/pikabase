const parameters = new URLSearchParams(window.location.search);
const gameId = parameters.get("id");
const gameTitle = document.getElementById("game-title");
const gameDiscussionList = document.getElementById("game-discussion-list");
const createDiscussionButton = document.getElementById("create-discussion-button");
const createDiscussionSection = document.getElementById("create-discussion-section");
const discussionForm = document.getElementById("discussion-form");

async function loadGame() {
    const response = await fetch(`/games/${gameId}`);

    if (!response.ok) {
        gameTitle.textContent = "Game could not be found.";
        return;
    }

    const game = await response.json();

    console.log(game);
    gameTitle.textContent = `${game.name} Discussions`;
}

async function loadGameDiscussions() {
    const response = await fetch(`/games/${gameId}/discussions`);

    if (!response.ok) {
        gameDiscussionList.textContent = "Discussions could not be loaded.";
        return;
    }

    const discussions = await response.json();
    gameDiscussionList.innerHTML = "";

    if (discussions.length === 0) {
        gameDiscussionList.textContent =
            "No discussions yet. Start the first one!";
        return;
    }

    discussions.forEach(discussion => {
        const card = document.createElement("article");
        card.classList.add("discussion-card");
    
        const title = document.createElement("h3");
        title.textContent = discussion.title;
    
        const footer = document.createElement("div");
        footer.classList.add("discussion-footer");
    
        const formattedDate = new Date(
            discussion.createdDate
        ).toLocaleDateString("en-CA", {
            year: "numeric",
            month: "long",
            day: "numeric"
        });
    
        const details = document.createElement("p");
        details.textContent =
            `Posted by ${discussion.authorName} • ${formattedDate}`;
    
        const viewButton = document.createElement("button");
        viewButton.textContent = "View →";
        viewButton.classList.add("view-button");
    
        viewButton.addEventListener("click", () => {
            window.location.href =
                `/discussion.html?id=${discussion.discussionId}`;
        });
    
        footer.appendChild(details);
        footer.appendChild(viewButton);
    
        card.appendChild(title);
        card.appendChild(footer);
    
        gameDiscussionList.appendChild(card);
    });

    console.log(discussions);
}

createDiscussionButton.addEventListener("click", () => {
    createDiscussionSection.style.display = "block";
});

discussionForm.addEventListener("submit", async event => {
    event.preventDefault();

    const title = document.getElementById("title").value;
    const authorName = document.getElementById("authorName").value;
    const content = document.getElementById("content").value;

    const discussion = {
        title: title,
        authorName: authorName,
        content: content
    };
    
    const response = await fetch(`/games/${gameId}/discussions`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(discussion)
    });
    
    if (!response.ok) {
        console.error("Discussion could not be created.");
        return;
    }

    discussionForm.reset();
    createDiscussionSection.style.display = "none";
    await loadGameDiscussions();
});

loadGame();
loadGameDiscussions();
console.log(gameId);