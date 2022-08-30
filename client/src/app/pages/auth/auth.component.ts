import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush,
  host: {
    'class': 'flex-1 items-center justify-center'
  }
})
export class AuthComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
