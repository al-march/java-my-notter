import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-main',
  template: `
    <app-header></app-header>

    <app-drawer class="flex-1">
      <router-outlet></router-outlet>
    </app-drawer>
  `,
  host: {
    'class': 'flex-1 h-screen flex flex-col'
  }
})
export class MainComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
