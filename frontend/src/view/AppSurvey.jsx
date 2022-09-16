import SurveyHeader from '../components/survey/SurveyHeader';
import SurveyMain from '../components/survey/SurveyMain';
import SurveyFooter from '../components/survey/SurveyFooter';

function AppSurvey() {
  return (
    <div
      style={{
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
      }}
    >
      <SurveyHeader />
      <SurveyMain />
      <SurveyFooter />
    </div>
  );
}

export default AppSurvey;
