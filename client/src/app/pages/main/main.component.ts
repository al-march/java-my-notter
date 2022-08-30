import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-main',
  template: `
    <app-header></app-header>

    <router-outlet></router-outlet>
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
