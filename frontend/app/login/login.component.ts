import { Component } from '@angular/core';
import { AuthService } from 'src/services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string = '';
  password: string = '';
  constructor(private authService: AuthService, private router: Router) { }

  login(): void {
    this.authService.login(this.username, this.password).subscribe(
      (response) => {
        const token = response.token; 
        this.authService.setToken(token); 

        
        this.router.navigate(['/customerquote']);

        alert('You have successfully logged in!');

      },

      (error) => {
        alert('Enter correct password');
        //console.error('Login failed:', error);

      }

    );

  }

}
