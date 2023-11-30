$(function (){

    $(".gun").click(function (){
        let random = Math.floor(Math.random()*12);
        let isShotted = $("#shelf-wrapper img").eq(random).css("rotate");

        if(isShotted !== '110deg'){
            $("#shelf-wrapper img").eq(random).animate({rotate:'-5deg'},100).animate({rotate:'110deg', marginTop:'+=40'},100).fadeOut('slow');
            $("#msg").text(`${random+1}번 인형을 맞췄어요!`).css("color","black");
        } else{
            $("#msg").text(`${random+1}꽝!!!`).css("color","white");
        }
    });





});