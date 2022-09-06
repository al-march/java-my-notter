import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { HomeComponent } from './home/home.component';
import { TemplateModule } from '@app/core/template';
import { DragDropModule } from '@angular/cdk/drag-drop';
import { NoteCardComponent } from './home/note-card/note-card.component';


@NgModule({
  declarations: [
    HomeComponent
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    TemplateModule,
    DragDropModule,
    NoteCardComponent,
  ]
})
export class HomeModule {}
