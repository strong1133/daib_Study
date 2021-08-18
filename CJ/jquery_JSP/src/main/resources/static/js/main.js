$(document).ready(function(){

});

function writeBoard(){
   let title =  $('#title').val();
   let content =  $('#content').val();

   if(title === "" || content === ""){
       alert("빈칸을 모두 채워주세요")
       return
   }
   let data = {
       "title": title,
       "content": content
   }
   $.ajax({
       url: '/board',
       type: 'POST',
       contentType: 'application/json',
       data: JSON.stringify(data),
       success: function (response){
           alert('작성 성공');
           window.location.reload()
       }
   });

}

function chkBtnClick(){

    let form = $("#formBox")[0];
    let formData = new FormData(form);
    console.log(formData)

    $.ajax({
            processData: false,
            contentType: false,
            data : formData,
            url :'/form',
            type : 'post',
            success: function(response){
                alert('작성 성공');
            }
    });
}