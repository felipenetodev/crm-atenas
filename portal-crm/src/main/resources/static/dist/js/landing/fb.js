function statusChangeCallback(response) {  
    console.log('statusChangeCallback');
    console.log(response);                   
    if (response.status === 'connected') {   
      testAPI();  
    } else {                                 
      console.log('Please log ' + 'into this webpage.');
    }
  }


  function checkLoginState() {               
    FB.getLoginStatus(function(response) {   
      statusChangeCallback(response);
    });
  }


  window.fbAsyncInit = function() {
    FB.init({
      appId      : '332949004333688',
      cookie     : true,                     
      xfbml      : true,                    
      version    : 'v7.0'          
    });


    FB.getLoginStatus(function(response) {   
      statusChangeCallback(response);        
    });
  };

  
  (function(d, s, id) {                      
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "https://connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));

 
  function testAPI() {
    FB.api('/me', { locale: 'en_US', fields: 'name, email, last_name, middle_name' }, function(response) {
    	$("#nome").val(response.name); 
        $("#sobrenome").val(response.last_name); 
        $("#email").val(response.email);
    });
  }