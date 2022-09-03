import { TagDto } from '@app/core/dto';

export interface NoteDto {
  id: number;
  userId: number;
  categoryId: number;

  name: string;
  description: string;

  tags: TagDto[];

  updatedAt: string;
  createdAt: string;
}

export interface NoteCreateDto {
  projectId?: number;
  title: string;
  description: string;
  tags: TagDto[];
}
