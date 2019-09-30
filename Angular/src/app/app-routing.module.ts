import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { OrderComponent } from './home/order/order.component';
import { ProfileComponent } from './profile/profile.component';
import { PaymentComponent } from './home/payment/payment.component';
import { NotificationComponent } from './home/notification/notification.component';
import { RewardComponent } from './home/reward/reward.component';
import { AddressComponent } from './home/address/address.component';
import { PancardComponent } from './home/pancard/pancard.component';


const routes: Routes = [
  {
    path: 'home',
    children:[
      {
        path:'order',
        component:OrderComponent
      },
      {
        path:'profile',
        component:ProfileComponent
      },
      {
        path:'payment',
      component:PaymentComponent
      },
      {
        path:'notification',
      component:NotificationComponent
      },
      {
        path:'reward',
      component:RewardComponent
      },
      {
        path:'address',
      component:AddressComponent
      },
    
      {
        path:'pancard',
      component:PancardComponent
      },
    
     
      
      {
        path:'',
        component:HomeComponent
      }
    ]    
  },
  {
    path: '',
    component:HomeComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

