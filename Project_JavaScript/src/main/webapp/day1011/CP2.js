$(function (){

$(".title").click(function (){
   $(".music-list").fadeIn('slow');
});

$(".music-list li").click(function (){
    let name = $(this).text();
    $(".title").text(name);

    let seletClass = $(this).attr("class");
    $("#cdImg").animate({width:'0'},300,function (){
        $("#cdImg").attr("class",seletClass).animate({width:'500px'},'slow');
    });
    $(".music-list").fadeOut('slow');
});

});