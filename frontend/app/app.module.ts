import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerquoteComponent } from './customerquote/customerquote.component';
import { HttpClientModule } from '@angular/common/http';
import { LocationComponent } from './location/location.component';
import { FormsModule } from '@angular/forms';
import { ProductComponent } from './product/product.component';
import { FeatureComponent } from './feature/feature.component';
import { ParameterComponent } from './parameter/parameter.component';
import { ProductService } from 'src/services/product.service';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ConfigurationComponent } from './configuration/configuration.component';
import { BillingComponent } from './billing/billing.component';
@NgModule({
  declarations: [
    AppComponent,
    CustomerquoteComponent,
    LocationComponent,
    ProductComponent,
    FeatureComponent,
    ParameterComponent,
    LoginComponent,
    RegisterComponent,
    ConfigurationComponent,
    BillingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
