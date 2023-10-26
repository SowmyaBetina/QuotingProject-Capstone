import { Component } from '@angular/core';
// import { QuoteService } from 'src/services/quote.customer';
// import { CustomerService } from 'src/services/customer.service';
import { CustomerQuoteService } from 'src/services/customerquote.service';

@Component({
  selector: 'app-customerquote',
  templateUrl: './customerquote.component.html',
  styleUrls: ['./customerquote.component.css']
})
export class CustomerquoteComponent {
  customerQuotes: any[] = [];

  constructor(private customerQuoteService: CustomerQuoteService) {}

  ngOnInit(): void {
    this.customerQuoteService.getCustomerQuotes().subscribe(
      (data) => {
        this.customerQuotes = data;
      }
    );
  }

  // onNextClick(){
    
  // }
}
