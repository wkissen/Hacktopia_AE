export interface Disease {
  id: number;
  diseaseName: string;
  type: string;
  heartRate: string;
  breathRate: string;
  bloodPressure: string;
  fever: string;
  incubationTime: number;
  periodOfIllness: number;
  duration: string;
  infectious: string;
  symptoms: string[];
}

export interface UserInfo {
  id: number;
  name: string;
  weight: number;
  age: number;
  height: number;
  medicines: any[];
  diseases: Disease[];
}
