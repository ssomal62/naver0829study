$(function () {
    $("#more").click(function () {
        var next_page = parseInt($(this).attr("current-page")) + 1;

        $.ajax({
            type: "GET",
            url : "/post",
            data: {"page": next_page}
        })
            .done(function (response) {
                for (var post of response) {
                    $("#more-posts").append(`
            <div class="post-preview">
                <a href="/post/${post.id}">
                    <h2 class="post-title">${post.title}</h2>
                    <h3 class="post-subtitle">${post.content}</h3>
                </a>
                <p class="post-meta">
                    ${post.username}
                </p>
            </div>
            <hr class="my-4"/>
                    `);
                }
            });
        $(this).attr("current-page", next_page);
    });


    $(".comment-edit").hide();

    $(".comment-edit-form-button").click(function () {
        $(this).closest(".comment_text").find(".comment-edit").show();
    });

    $(".comment-edit-cancel-button").click(function () {
        $(this).closest(".comment_text").find(".comment-edit").hide();
    });

    $("#create_button").click(function () {
        var title = $("#post-title").val();
        var username = $("#post-username").val();
        var content = $("#post-content").val();

        $.ajax({
            type           : "POST",
            url            : "/post",
            data           : JSON.stringify({
                "title"   : title,
                "content" : content,
                "username": username
            }), contentType: "application/json"
        })
            .done(function (response) {
                console.log("suceesssd");
                window.location.href = "/";
            })

    });

    $("#edit_button").click(function () {
        var id = $("#edit-post-id").val();
        var title = $("#edit-post-title").val();
        var content = $("#edit-post-content").val();

        $.ajax({
            type       : "PUT",
            url        : "/post",
            data       : JSON.stringify({
                "id"     : id,
                "title"  : title,
                "content": content,
            }),
            contentType: "application/json"
        }).done(function (response){
            window.location.href = "/post/" + id;
        });

    });

});

