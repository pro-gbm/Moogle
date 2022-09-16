import Option from './Option';

function SurveyMain() {
  return (
    <div style={{ backgroundColor: 'yellowgreen', width: '80%' }}>
      <div>질문지 영역</div>
      <Option />
      <Option />
      <Option />
      <div>버튼 영역</div>
    </div>
  );
}

export default SurveyMain;
