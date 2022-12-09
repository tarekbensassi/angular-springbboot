import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';
import { Role } from 'src/app/models/role';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, Input, OnInit } from '@angular/core';
@Component({
  selector: 'app-add-chefs',
  templateUrl: './add-chefs.component.html',
  styleUrls: ['./add-chefs.component.css']
})
export class AddChefsComponent implements OnInit {

  constructor(private _userService: UserService,
    private _router: Router) { }
    user: User = new User();
    roles: Role[] = [];


  ngOnInit(): void {
    this.listRoles();
  }
 

  listRoles() {
    this._userService.geRoles().subscribe(
      data => this.roles = data
    )
  }



  saveUser() {
    this._userService.saveUser(this.user).subscribe(
      data => {
        console.log('response', data);
        this._router.navigateByUrl("/chefs");
      }
    )
  }
}
