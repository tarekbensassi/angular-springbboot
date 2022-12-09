

import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';
import { Equipe } from 'src/app/models/equipe';
@Component({
  selector: 'app-list-chefs',
  templateUrl: './list-chefs.component.html',
  styleUrls: ['./list-chefs.component.css']
})
export class ListChefsComponent implements OnInit {

  users: User[] = [];
  user?: User ;
  equipes: Equipe[] = [];


  constructor(private _userService: UserService) { }

  ngOnInit(): void {
    this.listChefs();
   
    
      
  }
 

  listChefs() {
    this._userService.getChefs().subscribe(
      data => this.users = data
    )
  }

 
 
 

  
}

