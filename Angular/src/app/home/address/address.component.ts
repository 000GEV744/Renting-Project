import { InteractionService } from './../../interaction.service';
import { Component, OnInit } from '@angular/core';

import {FormGroup,FormControl, FormBuilder , Validators, NgForm, ControlContainer} from '@angular/forms';
@Component({
  selector: 'app-address',
  templateUrl: './address.component.html',
  styleUrls: ['./address.component.css']
})
export class AddressComponent implements OnInit {

  signupform:FormGroup;
  address:string;

  constructor(private interactionService:InteractionService, private formbuilder:FormBuilder) { }

  ngOnInit() {
    this.interactionService.accountInfo$
    .subscribe(
      message=>{
        console.log(message)
        this.address=message.customeraddress
        console.log(this.address);
      });
      this.signupform=this.formbuilder.group({
        address:[this.address,[Validators.required,Validators.minLength(6)]],
       })
  }

  postData(signupform:any){
    this.address=signupform.controls.address.value;
    
  }




}
