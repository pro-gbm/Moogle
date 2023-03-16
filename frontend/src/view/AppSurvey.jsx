/** @jsxImportSource @emotion/react */
import { css } from "@emotion/react";

import SurveyHeader from "../components/survey/SurveyHeader";
import SurveyMain from "../components/survey/SurveyMain";
import SurveyFooter from "../components/survey/SurveyFooter";

import { _data } from "../data";

const surveyStyle = css({
  display: "flex",
  flexDirection: "column",
  alignItems: "center",
  justifyContent: "space-between",
  height: "100%",
});

function AppSurvey() {
  const data = _data[1];

  return (
    <div css={surveyStyle}>
      <SurveyHeader />
      <SurveyMain data={data} />
      <SurveyFooter />
    </div>
  );
}

export default AppSurvey;
