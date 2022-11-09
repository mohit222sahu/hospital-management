import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Admin } from '../../entity/admin';
import { AdminService } from '../../service/admin.service';
import { TokenStorageService } from '../../service/token-storage.service';


@Component({
selector: 'app-login',
templateUrl: './login.component.html',
styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

admin : Admin = new Admin();
errorMsg : Boolean=false;
isLoggedIn = false;
isLoginFailed = false;

constructor(private adminService:AdminService,private router:Router,private tokenStorage: TokenStorageService) { }

onSubmit(){
  console.log("user=>",this.admin);
  this.adminService.check(this.admin).subscribe((data)=>{
    console.log(data.jwt);
    let tokenStr = "Bearer " + data.jwt;
    this.tokenStorage.saveToken(tokenStr);
  //  this.tokenStorage.saveUser(data);
    this.isLoginFailed = false;
    this.isLoggedIn = true;
    if(data)
     this.router.navigate(['/doctordashboard']);
    else this.errorMsg=true;
  })
  //this.router.navigate(['/doctordashboard']);
}

ngOnInit(): void {
}

}
