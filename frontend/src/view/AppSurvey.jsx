/** @jsxImportSource @emotion/react */
import { css } from '@emotion/react';

import SurveyHeader from '../components/survey/SurveyHeader';
import SurveyMain from '../components/survey/SurveyMain';
import SurveyFooter from '../components/survey/SurveyFooter';

import { useState } from 'react';

const surveyStyle = css({
  display: 'flex',
  flexDirection: 'column',
  alignItems: 'center',
  justifyContent: 'space-between',
  height: '100%',
});

function AppSurvey() {
  const [currentQuestion, setCurrentQuestion] = useState(1);

  const passCurrentQuestion = (paramNum) => {
    console.log('현재', paramNum);
    setCurrentQuestion(paramNum);
  };

  return (
    <div css={surveyStyle}>
      <SurveyHeader currentQuestion={currentQuestion} />
      <SurveyMain passCurrentQuestion={passCurrentQuestion} />
      <SurveyFooter />
    </div>
  );
}

export default AppSurvey;
