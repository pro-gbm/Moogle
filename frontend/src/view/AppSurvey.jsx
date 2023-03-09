import SurveyHeader from '../components/survey/SurveyHeader';
import SurveyMain from '../components/survey/SurveyMain';
import SurveyFooter from '../components/survey/SurveyFooter';

import { _data } from '../data';

function AppSurvey() {
  const data = _data[1];

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
      <SurveyMain data={data} />
      <SurveyFooter />
    </div>
  );
}

export default AppSurvey;
