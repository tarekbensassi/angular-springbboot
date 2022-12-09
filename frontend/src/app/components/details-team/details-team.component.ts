import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';
import { Equipe } from 'src/app/models/equipe';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-details-team',
  templateUrl: './details-team.component.html',
  styleUrls: ['./details-team.component.css']
})
export class DetailsTeamComponent implements OnInit {
  user?: any;
  equipe: Equipe = new Equipe();
  constructor(private _userService: UserService,
    private _router: Router,
    private _activatedRoute: ActivatedRoute) { }

    ngOnInit(): void {
        this.getTeams(this._activatedRoute.snapshot.params["id"]);
      
    }
    getTeams(id: number) {
    this._userService.getTeams(id).subscribe(
      data => this.user = data
    )
  }

  saveEquipe() {
    const id = this._activatedRoute.snapshot.params["id"];
    this._userService.saveEquipe(id,this.equipe).subscribe(
      data => {
        console.log('response', data);
        this._router.navigateByUrl("/chefs");
      }
    )
  }
  

  displayStyle = "none";
  
  openPopup() {
    this.displayStyle = "block";
  }
  closePopup() {
    this.displayStyle = "none";
  }
   


  


}
