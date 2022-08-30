import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PageTasksRoutingModule } from './page-tasks-routing.module';
import { PageTasksComponent } from './page-tasks.component';
import { TasksTreeComponent } from './tasks-tree/tasks-tree.component';
import { BadgeModule } from '@ng-daisy/data-display';


@NgModule({
  declarations: [
    PageTasksComponent,
    TasksTreeComponent
  ],
  imports: [
    CommonModule,
    PageTasksRoutingModule,
    BadgeModule
  ]
})
export class PageTasksModule { }
