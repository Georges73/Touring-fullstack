import { Component, OnInit } from '@angular/core';
import {Account} from '../account';
import { FrontEndService } from '../../front-end.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.scss']
})
export class AccountComponent implements OnInit {

   accounts: Account[];

 // accounts: Account[];

  constructor(private frontendService: FrontEndService, private location: Location){
  }

  ngOnInit() {
    this.getAccounts();
  }

  getAccounts(): void {
    this.frontendService.getAccounts().subscribe(accounts => this.accounts = accounts);
  }


}
