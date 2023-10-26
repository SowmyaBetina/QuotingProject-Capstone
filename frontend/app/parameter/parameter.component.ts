import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ParameterService } from 'src/services/parameter.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-parameter',
  templateUrl: './parameter.component.html',
  styleUrls: ['./parameter.component.css']
})
export class ParameterComponent {
  // parameters: any[] = [];
  // featureName: string = '';


  // constructor(
  //   private parameterService: ParameterService,
  //   private route: ActivatedRoute,
  //   private router: Router
  // ) {}

  // ngOnInit(): void {
  //   this.featureName = this.route.snapshot.paramMap.get('name')!;
    
  //   this.parameterService.getParametersForFeature(this.featureName).subscribe((data: any) => {
  //     this.parameters = data;
  //   });
  // }
  // navigateToConfiguration() {
  //   this.router.navigate(['/configuration']);
  // }


}
