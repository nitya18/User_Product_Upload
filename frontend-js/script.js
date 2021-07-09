function loginJS() {        

    console.log("hello");
     var res ;
    const url = "http://localhost:8080/loginUser";
    const data = {
        'userName' : document.getElementById('user').value,
        'password' : document.getElementById('pass').value
    };



    console.log(JSON.stringify(data));

    const other_params = {
        headers : { 'Accept': 'application/json, text/plain',
                'Content-Type': 'application/json;charset=UTF-8'},
        body : JSON.stringify(data),    
        method : "POST"
    };
    console.log(other_params);

     fetch(url, other_params)
        .then(response => response.json())
        .then(function(response) {

            if ((response.validated).includes('yes')){
                      window.location.href  = 'uploadView.html';

                      console.log(response.json());
                    
                return response.json();
            } else {
                alert(response.message);
                throw new Error(" " + response.message);
            }
        }).then(function(data) {
            alert(data.encoded);
        }).catch(function(error) {
            alert(error.message);
        });
    return false;
}



function registerJS() {   


    console.log("register");

    const url = "http://localhost:8080/registerUser";
    const data = {
        'userName' : document.getElementById('user').value,
        'password' : document.getElementById('pass').value,
        'firstName' : document.getElementById('lname').value,
        'lastName' : document.getElementById('fname').value,
        'emailId' : document.getElementById('email').value
    };

    console.log(data);

    const other_params = {
        headers : {  'Accept': 'application/json, text/plain',
                'Content-Type': 'application/json;charset=UTF-8' },
        body : JSON.stringify(data),  
        method : "POST"
    };

      console.log(other_params);

    fetch(url, other_params)
        .then(response => response.json())
        .then(function(response) {

            if ((response.validated).includes('yes')){
                if(response.message == null){
                    response.message = "Account successfully create! Please Login!";
                    alert(response.message);
                }
                      window.location.href  = 'index.html';
                      console.log(response.json());
                return response.json();
            } else {
                alert(response.message);
                throw new Error(" " + response.message);
            }
        }).then(function(data) {
            alert(data.encoded);
        }).catch(function(error) {
            alert(error.message);
        });



return false;
}



function uploadFile() {

        const url = "http://localhost:8080/uploadFile";
        file = document.getElementById('file').files[0];
        var loFormData = new FormData();
    loFormData.append("filename", file.name);
    loFormData.append("file", file);


    const other_params = {
        headers : { 'Accept': 'application/json, text/csv,text/plain'},
                /*'Content-Type': 'multipart/form-data, text/csv;charset=UTF-8'},*/
        body : loFormData,   
        method : "POST"
    };


 fetch(url, other_params)
        .then(response => response.json())
        .then(function(response) {

            if ((response)){
                      window.location.href  = 'dashBoard.html';
                      console.log(response.json());
                    
                return response.json();
            } else {
                alert(response.message);
                throw new Error(" " + response.message);
            }
        }).then(function(data) {
            alert(data.encoded);
        }).catch(function(error) {
            alert(error.message);
        });

/*    const upload = (file) => {
  fetch('http://localhost:8080/uploadFile', { // Your POST endpoint
    method: 'POST',
    headers: {
      // Content-Type may need to be completely **omitted**
      // or you may need something
      "Content-Type": "csv"
    },
    body: file // This is your file object
  }).then(
    response => response.json() // if the response is a JSON object
  ).then(
     success => console.log(success) // Handle the success response object
  ).catch(
    error => console.log(error) // Handle the error response object
  );
};*/

}

function uploadProducts() {

        const url = "http://localhost:8080/uploadFile/Products";
        file = document.getElementById('file').files[0];
        var loFormData = new FormData();
    loFormData.append("filename", file.name);
    loFormData.append("file", file);


    const other_params = {
        headers : { 'Accept': 'application/json, text/csv,text/plain'},
                /*'Content-Type': 'multipart/form-data, text/csv;charset=UTF-8'},*/
        body : loFormData,   
        method : "POST"
    };


 fetch(url, other_params)
        .then(response => response.json())
        .then(function(response) {

            if ((response)){
                      window.location.href  = 'dashBoard.html';
                      console.log(response.json());
                    
                return response.json();
            } else {
                alert(response.message);
                throw new Error(" " + response.message);
            }
        }).then(function(data) {
           alert(data.encoded);
        }).catch(function(error) {
            alert( error.message);
        });
}





function uploadHouseHolds() {

        const url = "http://localhost:8080/uploadFile/Households";
        file = document.getElementById('file').files[0];
        var loFormData = new FormData();
    loFormData.append("filename", file.name);
    loFormData.append("file", file);


    const other_params = {
        headers : { 'Accept': 'application/json, text/csv,text/plain'},
                /*'Content-Type': 'multipart/form-data, text/csv;charset=UTF-8'},*/
        body : loFormData,   
        method : "POST"
    };

 fetch(url, other_params)
        .then(response => response.json())
        .then(function(response) {

            if ((response)){
                      window.location.href  = 'dashBoard.html';
                      console.log(response.json());
                    
                return response.json();
            } else {
                alert(response.message);
                throw new Error(" " + response.message);
            }
        }).then(function(data) {
            alert( data.encoded);
        }).catch(function(error) {
            alert(error.message);
        });
}