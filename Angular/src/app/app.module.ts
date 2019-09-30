import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { OrderComponent } from './home/order/order.component';
import { PaymentComponent } from './home/payment/payment.component';
import { NotificationComponent } from './home/notification/notification.component';
import { RewardComponent } from './home/reward/reward.component';
import { LogoutComponent } from './home/logout/logout.component';
import { AddressComponent } from './home/address/address.component';
import { PancardComponent } from './home/pancard/pancard.component';
import { InteractionService } from './interaction.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ProfileComponent,
    OrderComponent,
    PaymentComponent,
    NotificationComponent,
    RewardComponent,
    LogoutComponent,
    AddressComponent,
    PancardComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule
  ],
  providers: [InteractionService],
  bootstrap: [AppComponent]
})
export class AppModule { }
