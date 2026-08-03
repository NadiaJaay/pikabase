const parameters = new URLSearchParams(window.location.search);
const discussionId = parameters.get("id");

const discussionDetails = document.getElementById("discussion-details");
const replyList = document.getElementById("reply-list");
const replyForm = document.getElementById("reply-form");

async function loadDiscussion() {
    const response = await fetch(`/discussions/${discussionId}`);

    if (!response.ok) {
        discussionDetails.textContent = "Discussion could not be found.";
        return;
    }

    const discussion = await response.json();

    const title = document.createElement("h1");
    title.textContent = discussion.title;

    const details = document.createElement("p");

    const formattedDate = new Date(
        discussion.createdDate
    ).toLocaleDateString("en-CA", {
        year: "numeric",
        month: "long",
        day: "numeric"
    });

    details.textContent =
        `Posted by ${discussion.authorName} • ${discussion.game.name} • ${formattedDate}`;

    const content = document.createElement("p");
    content.textContent = discussion.content;

    discussionDetails.innerHTML = "";

    discussionDetails.appendChild(title);
    discussionDetails.appendChild(details);
    discussionDetails.appendChild(content);
}

async function loadReplies() {
    const response = await fetch(
        `/discussions/${discussionId}/replies`
    );

    if (!response.ok) {
        replyList.textContent = "Replies could not be loaded.";
        return;
    }

    const replies = await response.json();

    replyList.innerHTML = "";

    if (replies.length === 0) {
        replyList.textContent = "No replies yet. Be the first to reply!";
        return;
    }

    replies.forEach(reply => {
        const replyCard = document.createElement("article");
        replyCard.classList.add("reply-card");

        const details = document.createElement("p");

        const formattedDate = new Date(
            reply.createdDate
        ).toLocaleDateString("en-CA", {
            year: "numeric",
            month: "long",
            day: "numeric"
        });

        details.textContent =
            `Posted by ${reply.authorName} • ${formattedDate}`;

        const content = document.createElement("p");
        content.textContent = reply.content;

        replyCard.appendChild(details);
        replyCard.appendChild(content);

        replyList.appendChild(replyCard);
    });
}

replyForm.addEventListener("submit", async event => {
    event.preventDefault();

    const authorName = document.getElementById("authorName").value;
    const content = document.getElementById("content").value;

    const reply = {
        authorName: authorName,
        content: content
    };

    const response = await fetch(
        `/discussions/${discussionId}/replies`,
        {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(reply)
        }
    );

    if (!response.ok) {
        console.error("Reply could not be posted.");
        return;
    }

    replyForm.reset();
    await loadReplies();
});

loadDiscussion();
loadReplies();