console.log("PikaBase frontend loaded");

const discussionList = document.getElementById("recent-discussion-list");

async function loadRecentDiscussions() {
    const response = await fetch("/discussions");
    const discussions = await response.json();

    const recentDiscussions = discussions
        .sort((a, b) => new Date(b.createdDate) - new Date(a.createdDate))
        .slice(0, 5);

    discussionList.innerHTML = "";

    recentDiscussions.forEach(discussion => {
        const card = document.createElement("article");
        card.classList.add("discussion-card");

        const footer = document.createElement("div");
        footer.classList.add('discussion-footer');

        const formattedDate = new Date(discussion.createdDate).toLocaleDateString(
            "en-CA",
            {
                year: "numeric",
                month: "short",
                day: "numeric"
            }
        );

        const title = document.createElement("h3");
        title.textContent = discussion.title;
        const details = document.createElement("p");
        details.textContent = `Posted by ${discussion.authorName} • ${discussion.game.name} • ${formattedDate}`;

        const viewButton = document.createElement("button");
        viewButton.textContent = "View Discussion";
        viewButton.classList.add("view-button");

        viewButton.addEventListener("click", () => {
            window.location.href = `discussion.html?id=${discussion.discussionId}`;
        });

        footer.appendChild(details);
        footer.appendChild(viewButton);

        card.appendChild(title);
        card.appendChild(footer);

        discussionList.appendChild(card);
    });
}

loadRecentDiscussions();