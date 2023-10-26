import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PriceService } from 'src/services/price.service';

@Component({
  selector: 'app-billing',
  templateUrl: './billing.component.html',
  styleUrls: ['./billing.component.css']
})
export class BillingComponent {
  productName: string = '';
  quantity: number = 1; 
  totalPrice: number = 0;
  paymentSuccessful: boolean = false;
  paymentDenied: boolean = false;

  constructor(private route: ActivatedRoute, private priceService: PriceService) {}

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.productName = params["productName"] || '';
      this.quantity = +params["quantity"] || 1;
      this.updateTotalPrice(); 
    });


  }

  updateTotalPrice(): void {
    if (this.productName && this.quantity) {
      this.priceService.calculatePrice(this.productName, this.quantity).subscribe(price => {
        this.totalPrice = price;
      });
    }
  }

  
  pay(): void {
    this.paymentSuccessful = true;
  }
  denyPayment(): void {
    this.paymentDenied = true; 
  }

}
