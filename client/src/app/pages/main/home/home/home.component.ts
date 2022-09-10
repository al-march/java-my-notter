import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { NoteService } from '@app/core/services';
import { ProfileService } from '@app/core/services/profile/profile.service';
import { CdkDragEnd, CdkDragMove } from '@angular/cdk/drag-drop';
import { NoteDragState } from './note-card/note-card.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  @ViewChild('dropZone')
  dropZone!: ElementRef<HTMLElement>;

  profile$ = this.profileService.get();
  notes$ = this.noteService.getAll();

  isDraggedToDropZone = false;

  constructor(
    private noteService: NoteService,
    private profileService: ProfileService
  ) {}

  ngOnInit(): void {
  }

  onNoteMoved($event: NoteDragState<CdkDragMove>) {
    const point = $event.event.pointerPosition;
    const elements = document.elementsFromPoint(point.x, point.y);
    const isDropZone = !!elements.find(el => this.dropZone.nativeElement === el);

    $event.component.inDropZone = isDropZone;

    if (this.isDraggedToDropZone !== isDropZone) {
      this.isDraggedToDropZone = isDropZone;
    }
  }

  onNoteDropped($event: NoteDragState<CdkDragEnd>) {
    this.isDraggedToDropZone = false;
    $event.component.inDropZone = false;
    console.log($event);
  }
}
