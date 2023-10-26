import { Component } from '@angular/core';
import { LocationService } from 'src/services/location.service';
import { OnInit } from '@angular/core';
import { AxiosError, AxiosResponse } from 'axios';
import axios from 'axios';
@Component({
  selector: 'app-location',
  templateUrl: './location.component.html',
  styleUrls: ['./location.component.css']
})
export class LocationComponent implements OnInit {
  locationDetails: any[] = [];
   location: any = {};
  
   constructor(private locationService: LocationService) { }
  

  ngOnInit(): void {
    this.locationService.getLocationDetails().subscribe((data) => {
      this.locationDetails = data;
    });
  }
  onSubmit() {
    this.locationService.addLocation(this.location).subscribe(
      (data) => {       
        console.log('Location added successfully:', data); 
        this.location = {};
      },
      (error) => {
        console.error('Error adding location:', error);
      }
    );

    const proxyUrl = 'https://cors-anywhere.herokuapp.com/';
axios.get(proxyUrl + `https://positionstack.com/geo_api.php?query=${this.location.city}`)
  .then((response: AxiosResponse) => {
    console.log(response.data);
  }).catch((error: AxiosError) => {
    console.log(error);
  });
  }

}

