import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LocationComponent } from './location/location.component';
import { CustomerquoteComponent } from './customerquote/customerquote.component';
import { ProductComponent } from './product/product.component';
import { ParameterComponent } from './parameter/parameter.component';
import { FeatureComponent } from './feature/feature.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { ConfigurationComponent } from './configuration/configuration.component';
import { BillingComponent } from './billing/billing.component';
const routes: Routes = [
  { path: '', redirectTo: '/register', pathMatch: 'full' },
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  //{ path: '', redirectTo: '/customerquote', pathMatch: 'full' }, 
  { path: 'customerquote', component: CustomerquoteComponent },
  { path: 'location', component: LocationComponent },
  { path: 'products', component: ProductComponent },
  { path: 'configuration', component: ConfigurationComponent },
  { path: 'features/:name', component: FeatureComponent },
  { path: 'billing', component: BillingComponent },
  //{ path: 'parameters/:name', component: ParameterComponent }
  
  
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
