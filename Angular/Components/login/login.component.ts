import { Component, OnInit } from '@angular/core';
import {Router, Route} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  constructor(private router: Router) { }

username: string;
password: string;
userId:string;
error:string;
url:string;
  
ngOnInit() {

  }

//once user click on login this function will get called 
  login() : void {
    
    //checking if someone has already logged in or in 
    this.userId=localStorage.getItem('token');
    
    if(this.userId==undefined){    //if no-one has logged in then only calling the fetch api for log in the user onto our website 
    this.url=`http://172.18.2.253:3000/login`;
    fetch(this.url,{
      method : "POST",
      headers: {
          "content-type": "application/json",
          'Accept': 'application/json'
         },
      body : JSON.stringify({
          email :this.username,
          password:this.password,
      })
  })
  .then(res=>res.json())
  .then(data=>{
    if(data[0]=="wrongcredentials"){ //incase creadentials are wrong 
      this.error="wrong creadentials"
    }
    else{  //incase creadentials are valid 
    localStorage.setItem('token',data[0])
    this.router.navigate(['home']);
    }

  })
}else{ //if user has already logged in then he will not be able to log once again 
  this.error="user already loggedin, logout first!"
  this.router.navigate(['home']);
}
}
}