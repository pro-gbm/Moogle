import Option from './Option';

function SurveyMain(props) {
  const { data } = props;

  return (
    <div
      style={{
        width: '80%',
        height: '100%',
        marginTop: '50px',
        display: 'flex',
        flexDirection: 'column',
        justifyContent: 'space-between',
        color: '#FFF',
      }}
    >
      <div style={{ fontSize: '2rem', marginLeft: '15%', marginRight: '15%' }}>
        {data.id}. {data.title}
      </div>
      <div
        style={{ marginLeft: '15%', marginRight: '15%', marginBottom: '30px' }}
      >
        {data.description}
      </div>
      <div style={{ minHeight: '75%', maxHeight: '80%' }}>
        {data.options.map((option, index) => (
          <Option key={`${option.id}-${index}`} data={option} />
        ))}
      </div>
      <div style={{ height: '10%', backgroundColor: '#2Ba' }}>버튼 영역</div>
    </div>
  );
}

export default SurveyMain;
