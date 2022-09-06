import { Component, OnInit } from '@angular/core';
import { NoteService } from '@app/core/services';
import { ProfileService } from '@app/core/services/profile/profile.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  profile$ = this.profileService.get();
  notes$ = this.noteService.getAll();

  constructor(
    private noteService: NoteService,
    private profileService: ProfileService
  ) {}

  ngOnInit(): void {
  }
}
