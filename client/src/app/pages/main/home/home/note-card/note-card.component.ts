import { Component, ElementRef, Input, OnInit, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DragDropModule } from '@angular/cdk/drag-drop';
import { NoteDto } from '@app/core/dto';

@Component({
  selector: 'app-note-card',
  standalone: true,
  imports: [CommonModule, DragDropModule],
  templateUrl: './note-card.component.html',
  styleUrls: ['./note-card.component.scss']
})
export class NoteCardComponent implements OnInit {

  @ViewChild('noteRef')
  noteRef?: ElementRef<HTMLElement>;

  @Input()
  note?: NoteDto;

  isDragging = false;
  transition = false;
  dragPosition = {x: 0, y: 0};

  constructor() { }

  ngOnInit(): void {
  }

  onDragStarted() {
    this.isDragging = true;
  }

  onDragDropped() {
    this.isDragging = false;
    this.transition = true;
    this.dragPosition = {x: 0, y: 0};

    const node = this.noteRef?.nativeElement;
    if (node) {
      node.ontransitioncancel = () => {
        this.transition = false;
      };
    }
  }
}
