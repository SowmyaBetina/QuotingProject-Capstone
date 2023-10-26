import { Component } from '@angular/core';
import { OnInit } from '@angular/core';
import { ProductService } from 'src/services/product.service';
import { Router } from '@angular/router';
import { FeatureService } from 'src/services/feature.service';
import { ParameterService } from 'src/services/parameter.service';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit{
  products!: any[]; 
  selectedProducts: string[] = [];

  constructor(private http: HttpClient, private productService: ProductService, private router: Router) {}

  ngOnInit(): void {
    
    this.productService.getProducts().subscribe((data: any) => {
      this.products = data;
    });
  }
  toggleProductSelection(product: any) {
    // Check if the product is already selected
    const index = this.selectedProducts.indexOf(product.name);
    if (index !== -1) {
      // If selected, remove it from the list
      this.selectedProducts.splice(index, 1);
    } else {
      // If not selected, add it to the list
      this.selectedProducts.push(product.name);
    }
  }

  // viewFeatures(productName: string) {
  //   this.router.navigate(['/features', productName]);
  // }

  navigateToConfiguration() {
    this.router.navigate(['/configuration']);
  }
 

}
