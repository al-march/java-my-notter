import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { TemplateService } from '@app/core/template';

@Component({
  selector: 'app-drawer',
  templateUrl: './drawer.component.html',
  styleUrls: ['./drawer.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush,
  host: {
    'class': 'flex-1'
  }
})
export class DrawerComponent implements OnInit {
  drawer$ = this.template.drawer$;

  constructor(
    private template: TemplateService,
  ) { }

  ngOnInit(): void {
  }

  open() {
    this.template.openDrawer();
  }

  close() {
    this.template.closeDrawer();
  }

  toggle() {
    this.template.toggleDrawer();
  }

}
