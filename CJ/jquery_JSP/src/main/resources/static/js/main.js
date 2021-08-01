$(document).ready(function(){
   alert('자스')
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