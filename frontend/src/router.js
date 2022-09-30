import AppMain from "./view/AppMain";
import AppResult from "./view/AppResult";
import AppSurvey from "./view/AppSurvey";

export const routers = [
  {
    id: 1,
    title: "Main Page",
    path: "/main",
    exact: true,
    component: AppMain,
  },
  {
    id: 2,
    title: "Result Page",
    path: "/result",
    exact: false,
    component: AppResult,
  },
  {
    id: 3,
    title: "Survey Page",
    path: "/survey",
    exact: false,
    component: AppSurvey,
  },
];
