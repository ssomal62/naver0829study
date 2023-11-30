
let  userID = "";
let  currentEventId = "";

const login_session = async () => {
    fetch("checkLoginStatus.jsp")
        .then(response => {
            if (!response.ok) {
                throw new Error('서버 응답 오류');
            }
            return response.json();
        })
        .then(data =>
            userID = data.loginId
        )
        .catch(error => {
            console.error("데이터 불러오기 실패:", error);
        });
}

window.addEventListener("load", () => {

    login_session();

    fetch("eventAction_List.jsp")
        .then(response => response.json())
        .then(data => {
            const dataTable = document.getElementById("dataTable");
            data.forEach(item => {
                const row = dataTable.insertRow();
                row.setAttribute("class", "events");
                row.setAttribute("id", item.event_id);
                row.setAttribute("data-bs-toggle", "modal");
                row.setAttribute("data-bs-target", "#eventModal");

                const cell1 = row.insertCell(0);
                const cell2 = row.insertCell(1);
                const cell3 = row.insertCell(2);
                const formattedDate =
                    new Intl.DateTimeFormat('ko-KR', {
                        year : 'numeric',
                        month: '2-digit',
                        day  : '2-digit'
                    }).format(item.e_end_date);

                cell1.innerHTML = item.title;
                cell2.innerHTML = item.user_id;
                cell3.innerHTML = formattedDate;
            });

            event_click();
        })




    const commentSendData = () => {

        const content = document.getElementById("c_content").value;
        let user_id = userID;
        let event_id = currentEventId;

        const url = `commentInsert.jsp?user_id=${user_id}&event_id=${event_id}&content=${content}`;

        fetch(url, {
            method : "GET",

        })
            .then(res => {
                if (res.ok === true) {
                    document.getElementById("c_content").value = "";
                    return;
                } else {
                    alert("등록 실패!");
                }
            })
            .catch(error => {
                console.error("등록 요청 실패:", error);
            });

    };

    const event_click = () => {


        const events = document.querySelectorAll(".events");


        events.forEach(event => {

            event.addEventListener('click', function () {

                if (userID == null) {
                    alert("회원만 확인가능합니다.")

                } else {
                    const eventId = this.getAttribute("id");
                    event_content(eventId);
                }
            });

        });


    }

    const commentAdd = document.getElementById("commentAdd");
    commentAdd.addEventListener("click", () => {
        commentSendData();
    });

    const comment_list = (eventId) => {
        const commentTable = document.getElementById("commentTable");
        commentTable.innerHTML = "";

        fetch(`commentAction_List.jsp?event_id=${eventId}`, {
            method : "POST",
            headers: {
                "Content-Type": "application/json"
            }
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('서버 응답 오류');
                }
                return response.json();
            })
            .then(cData => {

                cData.forEach(cItem => {

                    const row = commentTable.insertRow();

                    row.setAttribute("class", "comments");
                    row.setAttribute("id", cItem.comment_id);

                    const cell1 = row.insertCell(0);
                    const cell2 = row.insertCell(1);
                    const cell3 = row.insertCell(2);

                    const formattedDate =
                        new Intl.DateTimeFormat('ko-KR', {
                            year : 'numeric',
                            month: '2-digit',
                            day  : '2-digit'
                        }).format(cItem.comment_date);

                    row.setAttribute("event_id", cItem.event_id);
                   //alert(row.getAttribute("event_id"));

                    cell1.innerHTML = cItem.user_id;
                    cell2.innerHTML = cItem.content;
                    cell3.innerHTML = formattedDate;

                });


            })
            .catch(error => {
                console.error("데이터 불러오기 실패:", error);
            });


    }

    const event_content = (eventId) => {

        fetch(`eventAction_Search.jsp?event_id=${eventId}`, {
            method : "POST",
            headers: {
                "Content-Type" : "application/json"
            }
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('서버 응답 오류');
                }
                return response.json();
            })
            .then(content_data => {

                const eventDetail = document.getElementById("eventDetail");
                const modal_title = document.getElementById("modal-title");
                const comment_user_id = document.getElementById("comment_user_id");

                content_data.forEach(item => {

                    const startDate =
                        new Intl.DateTimeFormat('ko-KR', {
                            year : 'numeric',
                            month: '2-digit',
                            day  : '2-digit'
                        }).format(item.e_sta_date);
                    const endDate =
                        new Intl.DateTimeFormat('ko-KR', {
                            year : 'numeric',
                            month: '2-digit',
                            day  : '2-digit'
                        }).format(item.e_end_date);

                    modal_title.innerText = item.title;
                    comment_user_id.innerText = userID;
                    eventDetail.innerHTML =
                        `
                                ${item.user_id} ${startDate} ~ ${endDate}<br>
                                ${item.content}
                        `;

                    currentEventId = item.event_id;
                });

                comment_list(eventId);



            })
            .catch(error => {
                console.error("데이터 불러오기 실패:", error);
            });
    }
});