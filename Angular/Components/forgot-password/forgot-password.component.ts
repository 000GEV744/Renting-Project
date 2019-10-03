
import {FormGroup,FormControl, FormBuilder, Validators, NgForm} from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {
  showResetPassDiv=false;

  name:String;
  email:string; 
  password:String;
  gender:string;
  id:string;

  
  
  signupform:FormGroup; 
  error:string;
  url:string;
  resOtp:any;
  resTimeStamp:number;
  timeOutSession:number;

  constructor(private router:Router, private formbuilder:FormBuilder) { 
    this.signupform=formbuilder.group({
     
      password:['',[Validators.required,Validators.minLength(6)]],
      confirmPass:['',Validators.required],
      OTP:['',[Validators.required,Validators.minLength(5)]]
     
    },
    {validator: this.MustMatch('password', 'confirmPass')})  ;
  }


  ngOnInit() {
  }


  //generating current timestamp
  generateTime():number{
    let date = new Date();
    let timestamp = date.getTime();
    return timestamp;
  }



  sendOtpForResetPass(){

    this.url=`http://172.18.2.253:3000//findbyemail?email=`+this.email;
    fetch(this.url)
    .then(res=>res.json())
    .then(data=>{
      console.log(data)
      if(data[0]!=null){
        this.name=data[0].customername;
        this.email=data[0].customeremail;
        this.gender=data[0].customergender;
        this.id=data[0].id;
        console.log(this.name)
        //here we will set the first name and lname of the  valid user of our application
        this.url = `http://localhost:8081/resetpassword`
        fetch(this.url,{
          method : "POST",
          headers: {
              "content-type": "application/json",
              'Accept': 'application/json'
             },
          body : JSON.stringify({
              name:this.name,
              to:this.email,
              subject:"Reset Password OTP"
          })
      })
      .then(res=>res.json())
      .then(data=>{
      console.log("received")
      console.log(data);
      this.resOtp=data.otp;
      this.resTimeStamp=data.timeStamp;      
      })
      alert("An OTP has been sent to your verified emailId.");
      this.showResetPassDiv=true;
      }
      else{
        alert ('not a valid user!')
        this.router.navigate(['register'])
      }
    });
  }

  postData(signupform){
    
    this.password=signupform.controls.password.value;
    this.timeOutSession=5; //our timeout session is 5 min 
    let timestamp = this.generateTime();
    console.log(timestamp)
    console.log(this.resTimeStamp)
    let session=((timestamp-this.resTimeStamp)/60000);
    console.log(session)
    if(this.timeOutSession>session )
      {
        console.log("valid session")
        if(signupform.controls.OTP.value==this.resOtp)
        {
          console.log("valid OTP")
          this.url=`http://172.18.2.253:3000/register`
          fetch(this.url,{
            method : "POST",
            headers: {
                "content-type": "application/json",
                'Accept': 'application/json'
               },
               body : JSON.stringify({
                id:this.id,
                customername:this.name,
                customeremail:this.email,
                customerpassword:this.password,
                customergender:this.gender,
              })
          })
          .then(res=>res.json()) //getting the response the user registration
            .then(data=>{
              console.log(data[0]);
            })
            alert("password has been reset");
            this.router.navigate(['nav']);
        }
        else{
          alert("invalid OTP")
          this.router.navigate(['register']);
        }
      }else{
        alert('session expired')
        this.router.navigate(['register']);
      }

  }

  //password and confirm password matching 
  MustMatch(controlName: string, matchingControlName: string) {
    return (formGroup: FormGroup) => {
        const control = formGroup.controls[controlName];
        const matchingControl = formGroup.controls[matchingControlName];
    
        if (matchingControl.errors && !matchingControl.errors.mustMatch) {
            // return if another validator has already found an error on the matchingControl
            return;
        }
    
        // set error on matchingControl if validation fails
        if (control.value !== matchingControl.value) {
            matchingControl.setErrors({ mustMatch: true });
        } else {
            matchingControl.setErrors(null);
        }
    }
      }

}
