import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FeatureService } from 'src/services/feature.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-feature',
  templateUrl: './feature.component.html',
  styleUrls: ['./feature.component.css']
})
export class FeatureComponent implements OnInit{
  features!: any[];
  productName!: string;

  constructor(
    private featureService: FeatureService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    const productName = this.route.snapshot.paramMap.get('name');
    this.featureService.getFeaturesForProduct(productName).subscribe((data: any) => {
      console.log(data);
      
      this.features = data;
    });
  }
  
  navigateToConfiguration() {
    this.router.navigate(['/configuration']);
  }
  // navigateToParameters(featureName: string) {
  //   this.router.navigate(['/parameters', featureName]);
  // }
  
}
