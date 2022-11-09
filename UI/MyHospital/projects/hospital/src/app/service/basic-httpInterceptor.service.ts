import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler } from '@angular/common/http';
import { TokenStorageService } from './token-storage.service';


@Injectable({
  providedIn: 'root'
})
export class BasicAuthHtppInterceptorService implements HttpInterceptor {

  constructor(private sessionStorage: TokenStorageService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    let token =this.sessionStorage.getToken();
    //console.log("interceptor is active==================> "+token);
    if (token) {
      req = req.clone({
        setHeaders: {
          Authorization: token
        }
      })
    }
    return next.handle(req);
  }
}
