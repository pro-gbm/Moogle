import Option from './Option';

function SurveyMain() {
  return (
    <div
      style={{
        backgroundColor: 'yellowgreen',
        width: '80%',
        height: '100%',
        display: 'flex',
        flexDirection: 'column',
        justifyContent: 'space-between',
      }}
    >
      <div>질문지 영역</div>
      <div style={{ height: '80%', backgroundColor: 'aliceblue' }}>
        <Option />
        <Option />
        <Option />
      </div>
      <div>버튼 영역</div>
    </div>
  );
}

export default SurveyMain;
