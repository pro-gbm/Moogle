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
        justifyContent: 'space-between',
        height: '100%',
      }}
    >
      <SurveyHeader />
      <SurveyMain />
      <SurveyFooter />
    </div>
  );
}

export default AppSurvey;
