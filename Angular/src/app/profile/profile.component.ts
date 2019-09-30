import { InteractionService } from './../interaction.service';
import { Component, OnInit } from '@angular/core';
import {FormGroup,FormControl, FormBuilder, Validators, NgForm, ControlContainer} from '@angular/forms';
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  signupform:FormGroup;

  name:string;
  gender: string;
  number:string
  email:string;
  

  constructor(private interactionService:InteractionService, private formbuilder:FormBuilder) {
   
   }

  ngOnInit() {
    this.interactionService.accountInfo$
    .subscribe(
      message=>{ 
        console.log(message)       
        this.name=message.customername;
        this.email=message.customeremail
        this.gender=message.customergender;
        this.number=message.customercontact;
      }
    );
    this.signupform=this.formbuilder.group({
      name:[this.name,[Validators.required,Validators.minLength(3)]],
       gender: [this.gender,Validators.required],
       number : [this.number,Validators.required],
       email:[this.email,[Validators.required, Validators.email]]
     })
     
  }


  postData(signupform:any){
    this.name=signupform.controls.name.value;
    
  }

}
