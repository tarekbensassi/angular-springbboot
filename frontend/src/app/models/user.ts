import { Role } from "./role";
import { Equipe } from "./equipe";

export class User {
    id?: number;
    firstname?: string;
    lastname?: string;
    project?: string;
    roles?:Role;
    equipes?:Equipe[];
}
