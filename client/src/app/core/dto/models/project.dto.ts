import { TagDto, TaskDto } from '@app/core/dto';

export interface ProjectDto {
  id: number;
  userId: number;
  title: string;
  description: string;
  tags: TagDto[];
  tasks: TaskDto[];
  createdAt: string;
  updatedAt: string;
}

export interface ProjectCreateDto {
  title: string;
  description: string;
  tags?: TagDto[],
}
