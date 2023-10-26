import { Component } from '@angular/core';
import { ProductService } from 'src/services/product.service';
import { FeatureService } from 'src/services/feature.service';
import { Router } from '@angular/router';
import { PriceService } from 'src/services/price.service';
import { LocationService } from 'src/services/location.service';
@Component({
  selector: 'app-configuration',
  templateUrl: './configuration.component.html',
  styleUrls: ['./configuration.component.css']
})
export class ConfigurationComponent {
  products: string[] = []; 
  selectedName: string = '';
  selectedProductDetails: any = null;
  productName: string = '';
  quantity: number = 1; 
  totalPrice: number = 0;
  locationData: any[] = [];

  constructor(private productService: ProductService, private featureService: FeatureService, private router: Router, private priceService: PriceService, private locationService: LocationService) {}

  ngOnInit(): void {
    this.productService.getProductNames().subscribe((data: string[]) => {
      this.products = data;
    });
    this.locationService.getLocationDetails().subscribe((data) => {
      this.locationData = data;
    });
  }
  enableFeatures(productName: string): void {
    if (productName) {
      
      this.featureService.getProductDetails(productName).subscribe((data: any) => {
        this.selectedProductDetails = data;
      });
    }
  }

  updateTotalPrice(): void {
    if (this.selectedName && this.quantity) {
      this.priceService.calculatePrice(this.selectedName, this.quantity).subscribe((data: number) => {
        this.totalPrice = data;
      });
    }
  }
  billNow(): void {
    this.router.navigate(['/billing'], {
      queryParams: { 
        productName: this.selectedName,
        quantity: this.quantity
      }
    });
  }

  viewFeatures(productName: string) {
    this.router.navigate(['/features', productName]);
  }

  

}
